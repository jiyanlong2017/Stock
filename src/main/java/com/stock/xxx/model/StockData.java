package com.stock.xxx.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by JiYanLong on 2017/3/10.
 */
@Entity
@Table(name = "stock_data")
public class StockData extends BaseModel<Integer> {
    private static final long serialVersionUID = -312058123906332069L;
    private Integer id;
    private String stockName;
    private String tradeMoney;
    private String diffMoney;
    private String openPrice;
    private String code;
    private Timestamp date;
    private String market;
    private String minPrice;
    private String tradeNum;
    private String turnover;
    private String closePrice;
    private String maxPrice;
    private String swing;
    private String diffRate;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "stockName")
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Basic
    @Column(name = "trade_money")
    public String getTradeMoney() {
        return tradeMoney;
    }

    public void setTradeMoney(String tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    @Basic
    @Column(name = "diff_money")
    public String getDiffMoney() {
        return diffMoney;
    }

    public void setDiffMoney(String diffMoney) {
        this.diffMoney = diffMoney;
    }

    @Basic
    @Column(name = "open_price")
    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "market")
    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    @Basic
    @Column(name = "min_price")
    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    @Basic
    @Column(name = "trade_num")
    public String getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(String tradeNum) {
        this.tradeNum = tradeNum;
    }

    @Basic
    @Column(name = "turnover")
    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    @Basic
    @Column(name = "close_price")
    public String getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    @Basic
    @Column(name = "max_price")
    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Basic
    @Column(name = "swing")
    public String getSwing() {
        return swing;
    }

    public void setSwing(String swing) {
        this.swing = swing;
    }

    @Basic
    @Column(name = "diff_rate")
    public String getDiffRate() {
        return diffRate;
    }

    public void setDiffRate(String diffRate) {
        this.diffRate = diffRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockData that = (StockData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (stockName != null ? !stockName.equals(that.stockName) : that.stockName != null) return false;
        if (tradeMoney != null ? !tradeMoney.equals(that.tradeMoney) : that.tradeMoney != null) return false;
        if (diffMoney != null ? !diffMoney.equals(that.diffMoney) : that.diffMoney != null) return false;
        if (openPrice != null ? !openPrice.equals(that.openPrice) : that.openPrice != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (market != null ? !market.equals(that.market) : that.market != null) return false;
        if (minPrice != null ? !minPrice.equals(that.minPrice) : that.minPrice != null) return false;
        if (tradeNum != null ? !tradeNum.equals(that.tradeNum) : that.tradeNum != null) return false;
        if (turnover != null ? !turnover.equals(that.turnover) : that.turnover != null) return false;
        if (closePrice != null ? !closePrice.equals(that.closePrice) : that.closePrice != null) return false;
        if (maxPrice != null ? !maxPrice.equals(that.maxPrice) : that.maxPrice != null) return false;
        if (swing != null ? !swing.equals(that.swing) : that.swing != null) return false;
        if (diffRate != null ? !diffRate.equals(that.diffRate) : that.diffRate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        result = 31 * result + (tradeMoney != null ? tradeMoney.hashCode() : 0);
        result = 31 * result + (diffMoney != null ? diffMoney.hashCode() : 0);
        result = 31 * result + (openPrice != null ? openPrice.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (market != null ? market.hashCode() : 0);
        result = 31 * result + (minPrice != null ? minPrice.hashCode() : 0);
        result = 31 * result + (tradeNum != null ? tradeNum.hashCode() : 0);
        result = 31 * result + (turnover != null ? turnover.hashCode() : 0);
        result = 31 * result + (closePrice != null ? closePrice.hashCode() : 0);
        result = 31 * result + (maxPrice != null ? maxPrice.hashCode() : 0);
        result = 31 * result + (swing != null ? swing.hashCode() : 0);
        result = 31 * result + (diffRate != null ? diffRate.hashCode() : 0);
        return result;
    }
}
