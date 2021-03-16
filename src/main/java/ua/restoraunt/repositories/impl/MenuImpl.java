package ua.restoraunt.repositories.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import ua.restoraunt.domain.Menu;
import ua.restoraunt.repositories.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@org.springframework.stereotype.Repository
public class MenuImpl implements Repository<Menu> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Menu> menuRowMapper;

    public MenuImpl(JdbcTemplate jdbcTemplate, RowMapper<Menu> menuRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.menuRowMapper = menuRowMapper;
    }


    @Override
    public Menu create(Menu entity) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("insert into menu(id_restoraunt,name,price,weight,time_of_cooking) " +
                    "values (?,?,?,?,?)");
            ps.setInt(1, entity.getIdRestoraunt());
            ps.setString(2, entity.getName());
            ps.setDouble(3, entity.getPrice());
            ps.setDouble(4, entity.getWeight());
            ps.setDouble(5, entity.getTimeOfCooking());
            return ps;
        }, generatedKeyHolder);
        return null;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(
                "delete from menu where id = ?", id);
    }

    @Override
    public Menu update(Menu entity) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("update menu set id_restoraunt = ?,name = ?,price = ?,weight = ?," +
                    " time_of_cooking = ? " +
                    "where id = ?");
            ps.setInt(1, entity.getIdRestoraunt());
            ps.setString(2, entity.getName());
            ps.setDouble(3, entity.getPrice());
            ps.setDouble(4, entity.getWeight());
            ps.setDouble(5, entity.getTimeOfCooking());
            ps.setInt(6, entity.getId());
            return ps;
        }, generatedKeyHolder);
        return null;
    }

    @Override
    public Menu get(int id) {
        return jdbcTemplate.queryForObject("select * from menu where id = ?", menuRowMapper, id);

    }

    @Override
    public List<Menu> getAll() {
        return jdbcTemplate.query("select * from menu", menuRowMapper);
    }
}
