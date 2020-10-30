package qwerty.tourss.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import qwerty.tourss.Dao.model.Tour;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class TourDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(Tour t) {
        String sql = "INSERT INTO Tour1(tourName, description, country, price) values('"+t.getTourName()+"','"+t.getDescription()+"','"+t.getCountry()+"','"+t.getPrice()+"')";
        return jdbcTemplate.update(sql);
    }

    public int update(Tour t) {
        String sql = "UPDATE Tour1 SET tourName='"+t.getTourName()+"', description="+t.getDescription()+",country='"+t.getCountry()+"', price="+t.getPrice()+" where id="+t.getId()+"";
        return jdbcTemplate.update(sql);
    }

    public int delete(int id){
        String sql="delete from Tour1 where id="+id+"";
        return jdbcTemplate.update(sql);
    }

    public Tour getEmpById(int id){
        String sql="select * from Tour1 where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Tour>(Tour.class));
    }

    public List<Tour> getEmployees(){
        return jdbcTemplate.query("select * from Tour1",new RowMapper<Tour>(){
            public Tour mapRow(ResultSet rs, int row) throws SQLException {
                Tour e = new Tour();
                e.setId(rs.getInt(1));
                e.setTourName(rs.getString(2));
                e.setDescription(rs.getString(3));
                e.setCountry(rs.getString(4));
                e.setPrice(rs.getInt(5));
                return e;
            }
        });
    }
}
