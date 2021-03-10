package ua.restoraunt.repositories.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import ua.restoraunt.domain.Restoraunt;
import ua.restoraunt.repositories.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@org.springframework.stereotype.Repository
public class RestorauntImpl implements Repository<Restoraunt> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Restoraunt> restorauntRowMapper;

    public RestorauntImpl(JdbcTemplate jdbcTemplate,
                          RowMapper<Restoraunt> restorauntRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.restorauntRowMapper = restorauntRowMapper;
    }

    @Override
    public long create(Restoraunt entity) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("insert into restoraunt_info(name,has_delivery,link_to_site,count_of_employers,is_alcohol_allowed,has_summer_platform, time_of_work) " +
                    "values (?,?,?,?,?,?,?)");
            ps.setString(1, entity.getName());
            ps.setBoolean(2, entity.isHasDelivery());
            ps.setString(3, entity.getLinkToSite());
            ps.setInt(4, entity.getCountOfEmployers());
            ps.setBoolean(5, entity.isAlcoholAllowed());
            ps.setBoolean(6, entity.isHasSummerPlatform());
            ps.setString(7, entity.getTimeOfWork());
            return ps;
        }, generatedKeyHolder);
        return 0;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(
                "delete from restoraunt_info where id = ?", id);
    }

    @Override
    public long update(Restoraunt entity) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("update restoraunt_info " +
                    " set name = ?,has_delivery = ?," +
                    " link_to_site = ?,count_of_employers = ?," +
                    " is_alcohol_allowed = ?,has_summer_platform = ?, time_of_work = ? " +
                    "where id = ?");
            ps.setString(1, entity.getName());
            ps.setBoolean(2, entity.isHasDelivery());
            ps.setString(3, entity.getLinkToSite());
            ps.setInt(4, entity.getCountOfEmployers());
            ps.setBoolean(5, entity.isAlcoholAllowed());
            ps.setBoolean(6, entity.isHasSummerPlatform());
            ps.setString(7, entity.getTimeOfWork());
            ps.setInt(8, entity.getId());
            return ps;
        }, generatedKeyHolder);
        return 0;
    }

    @Override
    public Restoraunt get(int id) {
        return jdbcTemplate.queryForObject("select * from restoraunt_info where id = ?", restorauntRowMapper, id);
    }

    @Override
    public List<Restoraunt> getAll() {
        return jdbcTemplate.query("select * from restoraunt_info", restorauntRowMapper);
    }
}

