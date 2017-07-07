package com.stock.xxx.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by JiYanLong on 2017/3/8.
 */
@Entity
@Table(name = "stock_history", schema = "stock", catalog = "")
public class StockHistory extends BaseModel<Integer>{
    private static final long serialVersionUID = 1943922982734296978L;
    private Integer id;
    private String stockname;
    private BigDecimal kprice;
    private BigDecimal sprice;
    private BigDecimal cprice;
    private BigDecimal hprice;
    private BigDecimal lprice;
    private BigDecimal jiheprice1;
    private BigDecimal jiheprice2;
    private Long volume;
    private String totalprice;
    private BigDecimal price1;
    private BigDecimal price2;
    private BigDecimal price3;
    private BigDecimal price4;
    private BigDecimal price5;
    private BigDecimal pricea;
    private BigDecimal priceb;
    private BigDecimal pricec;
    private BigDecimal priced;
    private BigDecimal pricee;
    private Timestamp date;
    private Integer mai1;
    private Integer mai2;
    private Integer mai3;
    private Integer mai4;
    private Integer mai5;
    private Integer maia;
    private Integer maib;
    private Integer maic;
    private Integer maid;
    private Integer maie;
    private String code;

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
    @Column(name = "stockname")
    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    @Basic
    @Column(name = "kprice")
    public BigDecimal getKprice() {
        return kprice;
    }

    public void setKprice(BigDecimal kprice) {
        this.kprice = kprice;
    }

    @Basic
    @Column(name = "sprice")
    public BigDecimal getSprice() {
        return sprice;
    }

    public void setSprice(BigDecimal sprice) {
        this.sprice = sprice;
    }

    @Basic
    @Column(name = "cprice")
    public BigDecimal getCprice() {
        return cprice;
    }

    public void setCprice(BigDecimal cprice) {
        this.cprice = cprice;
    }

    @Basic
    @Column(name = "hprice")
    public BigDecimal getHprice() {
        return hprice;
    }

    public void setHprice(BigDecimal hprice) {
        this.hprice = hprice;
    }

    @Basic
    @Column(name = "lprice")
    public BigDecimal getLprice() {
        return lprice;
    }

    public void setLprice(BigDecimal lprice) {
        this.lprice = lprice;
    }

    @Basic
    @Column(name = "jiheprice1")
    public BigDecimal getJiheprice1() {
        return jiheprice1;
    }

    public void setJiheprice1(BigDecimal jiheprice1) {
        this.jiheprice1 = jiheprice1;
    }

    @Basic
    @Column(name = "jiheprice2")
    public BigDecimal getJiheprice2() {
        return jiheprice2;
    }

    public void setJiheprice2(BigDecimal jiheprice2) {
        this.jiheprice2 = jiheprice2;
    }

    @Basic
    @Column(name = "volume")
    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "totalprice")
    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    @Basic
    @Column(name = "price1")
    public BigDecimal getPrice1() {
        return price1;
    }

    public void setPrice1(BigDecimal price1) {
        this.price1 = price1;
    }

    @Basic
    @Column(name = "price2")
    public BigDecimal getPrice2() {
        return price2;
    }

    public void setPrice2(BigDecimal price2) {
        this.price2 = price2;
    }

    @Basic
    @Column(name = "price3")
    public BigDecimal getPrice3() {
        return price3;
    }

    public void setPrice3(BigDecimal price3) {
        this.price3 = price3;
    }

    @Basic
    @Column(name = "price4")
    public BigDecimal getPrice4() {
        return price4;
    }

    public void setPrice4(BigDecimal price4) {
        this.price4 = price4;
    }

    @Basic
    @Column(name = "price5")
    public BigDecimal getPrice5() {
        return price5;
    }

    public void setPrice5(BigDecimal price5) {
        this.price5 = price5;
    }

    @Basic
    @Column(name = "pricea")
    public BigDecimal getPricea() {
        return pricea;
    }

    public void setPricea(BigDecimal pricea) {
        this.pricea = pricea;
    }

    @Basic
    @Column(name = "priceb")
    public BigDecimal getPriceb() {
        return priceb;
    }

    public void setPriceb(BigDecimal priceb) {
        this.priceb = priceb;
    }

    @Basic
    @Column(name = "pricec")
    public BigDecimal getPricec() {
        return pricec;
    }

    public void setPricec(BigDecimal pricec) {
        this.pricec = pricec;
    }

    @Basic
    @Column(name = "priced")
    public BigDecimal getPriced() {
        return priced;
    }

    public void setPriced(BigDecimal priced) {
        this.priced = priced;
    }

    @Basic
    @Column(name = "pricee")
    public BigDecimal getPricee() {
        return pricee;
    }

    public void setPricee(BigDecimal pricee) {
        this.pricee = pricee;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockHistory that = (StockHistory) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (stockname != null ? !stockname.equals(that.stockname) : that.stockname != null) return false;
        if (kprice != null ? !kprice.equals(that.kprice) : that.kprice != null) return false;
        if (sprice != null ? !sprice.equals(that.sprice) : that.sprice != null) return false;
        if (cprice != null ? !cprice.equals(that.cprice) : that.cprice != null) return false;
        if (hprice != null ? !hprice.equals(that.hprice) : that.hprice != null) return false;
        if (lprice != null ? !lprice.equals(that.lprice) : that.lprice != null) return false;
        if (jiheprice1 != null ? !jiheprice1.equals(that.jiheprice1) : that.jiheprice1 != null) return false;
        if (jiheprice2 != null ? !jiheprice2.equals(that.jiheprice2) : that.jiheprice2 != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (totalprice != null ? !totalprice.equals(that.totalprice) : that.totalprice != null) return false;
        if (price1 != null ? !price1.equals(that.price1) : that.price1 != null) return false;
        if (price2 != null ? !price2.equals(that.price2) : that.price2 != null) return false;
        if (price3 != null ? !price3.equals(that.price3) : that.price3 != null) return false;
        if (price4 != null ? !price4.equals(that.price4) : that.price4 != null) return false;
        if (price5 != null ? !price5.equals(that.price5) : that.price5 != null) return false;
        if (pricea != null ? !pricea.equals(that.pricea) : that.pricea != null) return false;
        if (priceb != null ? !priceb.equals(that.priceb) : that.priceb != null) return false;
        if (pricec != null ? !pricec.equals(that.pricec) : that.pricec != null) return false;
        if (priced != null ? !priced.equals(that.priced) : that.priced != null) return false;
        if (pricee != null ? !pricee.equals(that.pricee) : that.pricee != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (stockname != null ? stockname.hashCode() : 0);
        result = 31 * result + (kprice != null ? kprice.hashCode() : 0);
        result = 31 * result + (sprice != null ? sprice.hashCode() : 0);
        result = 31 * result + (cprice != null ? cprice.hashCode() : 0);
        result = 31 * result + (hprice != null ? hprice.hashCode() : 0);
        result = 31 * result + (lprice != null ? lprice.hashCode() : 0);
        result = 31 * result + (jiheprice1 != null ? jiheprice1.hashCode() : 0);
        result = 31 * result + (jiheprice2 != null ? jiheprice2.hashCode() : 0);
        result = 31 * result + (volume != null ? volume.hashCode() : 0);
        result = 31 * result + (totalprice != null ? totalprice.hashCode() : 0);
        result = 31 * result + (price1 != null ? price1.hashCode() : 0);
        result = 31 * result + (price2 != null ? price2.hashCode() : 0);
        result = 31 * result + (price3 != null ? price3.hashCode() : 0);
        result = 31 * result + (price4 != null ? price4.hashCode() : 0);
        result = 31 * result + (price5 != null ? price5.hashCode() : 0);
        result = 31 * result + (pricea != null ? pricea.hashCode() : 0);
        result = 31 * result + (priceb != null ? priceb.hashCode() : 0);
        result = 31 * result + (pricec != null ? pricec.hashCode() : 0);
        result = 31 * result + (priced != null ? priced.hashCode() : 0);
        result = 31 * result + (pricee != null ? pricee.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "mai1")
    public Integer getMai1() {
        return mai1;
    }

    public void setMai1(Integer mai1) {
        this.mai1 = mai1;
    }

    @Basic
    @Column(name = "mai2")
    public Integer getMai2() {
        return mai2;
    }

    public void setMai2(Integer mai2) {
        this.mai2 = mai2;
    }

    @Basic
    @Column(name = "mai3")
    public Integer getMai3() {
        return mai3;
    }

    public void setMai3(Integer mai3) {
        this.mai3 = mai3;
    }

    @Basic
    @Column(name = "mai4")
    public Integer getMai4() {
        return mai4;
    }

    public void setMai4(Integer mai4) {
        this.mai4 = mai4;
    }

    @Basic
    @Column(name = "mai5")
    public Integer getMai5() {
        return mai5;
    }

    public void setMai5(Integer mai5) {
        this.mai5 = mai5;
    }

    @Basic
    @Column(name = "maia")
    public Integer getMaia() {
        return maia;
    }

    public void setMaia(Integer maia) {
        this.maia = maia;
    }

    @Basic
    @Column(name = "maib")
    public Integer getMaib() {
        return maib;
    }

    public void setMaib(Integer maib) {
        this.maib = maib;
    }

    @Basic
    @Column(name = "maic")
    public Integer getMaic() {
        return maic;
    }

    public void setMaic(Integer maic) {
        this.maic = maic;
    }

    @Basic
    @Column(name = "maid")
    public Integer getMaid() {
        return maid;
    }

    public void setMaid(Integer maid) {
        this.maid = maid;
    }

    @Basic
    @Column(name = "maie")
    public Integer getMaie() {
        return maie;
    }

    public void setMaie(Integer maie) {
        this.maie = maie;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
