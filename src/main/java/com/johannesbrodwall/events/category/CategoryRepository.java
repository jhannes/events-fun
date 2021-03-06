package com.johannesbrodwall.events.category;

import com.johannesbrodwall.infrastructure.db.Database;
import com.johannesbrodwall.infrastructure.db.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CategoryRepository implements Repository<Category> {

    @Override
    public List<Category> findAll() {
        String query = "select * from event_categories";
        return Database.executeQueryForAll(query, (ResultSet rs) -> {
           return new Category(rs.getInt("id"), rs.getString("displayName"), rs.getString("color"));
        });
    }

    @Override
    public void insert(Category category) {
        String query = "insert into event_categories (displayName, color) values (?, ?)";
        Database.executeInsert(query, (PreparedStatement stmt) -> {
            stmt.setString(1, category.getDisplayName());
            stmt.setString(2, category.getColor());
        });
        category.setId(Database.queryForInt("SELECT last_value FROM event_categories_id_seq"));
    }

    @Override
    public Category fetch(Integer id) {
        String query = "select * from event_categories where id = ?";
        return Database.executePreparedQuery(query,
                (PreparedStatement stmt) -> {
                    stmt.setLong(1, id);
                },
                (ResultSet rs) -> {
                    return new Category(rs.getInt("id"), rs.getString("displayName"), rs.getString("color"));
                });
    }

}
