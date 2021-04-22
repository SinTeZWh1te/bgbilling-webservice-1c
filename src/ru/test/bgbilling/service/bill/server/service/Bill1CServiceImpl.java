package ru.test.bgbilling.service.bill.server.service;

import ru.test.bgbilling.service.bill.common.bean.Bill1CPayment;
import ru.test.bgbilling.service.bill.common.service.Bill1CService;
import ru.bitel.bgbilling.common.BGMessageException;
import ru.bitel.bgbilling.kernel.container.service.server.AbstractService;
import ru.bitel.bgbilling.server.util.ServerUtils;
import ru.bitel.common.TimeUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sintezwh1te
 */

public class Bill1CServiceImpl extends AbstractService implements Bill1CService {

    private Connection con;

    public Bill1CServiceImpl() {
    }

    @PostConstruct
    protected void init() {
        con = this.getConnection();
    }

    @PreDestroy
    private void destroy() {
        if (con != null) {
            ServerUtils.commitConnection(con);
            ServerUtils.closeConnection(con);
        }
    }

    @Override
    public List<Bill1CPayment> getPaymentList(Date date) throws BGMessageException {
        List<Bill1CPayment> result = new ArrayList<>();
        String query = "SELECT c.id, c.title, c.comment, p.id, pt.title, p.summa, p.comment " +
                " FROM contract_payment AS p " +
                " LEFT JOIN contract AS c ON p.cid = c.id " +
                " LEFT JOIN contract_payment_types AS pt ON pt.id = p.pt " +
                " WHERE p.dt = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDate(1, TimeUtils.convertDateToSqlDate(date));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(new Bill1CPayment(rs.getInt("c.id"),
                            rs.getInt("p.id"),
                            rs.getString("c.title"),
                            rs.getString("c.comment"),
                            rs.getString("pt.title"),
                            rs.getString("p.comment"),
                            rs.getBigDecimal("p.summa")));
                }
            }
        } catch (SQLException e) {
            throw new BGMessageException(e.getMessage());
        }
        return result;
    }
}
                 