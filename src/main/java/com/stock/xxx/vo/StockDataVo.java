package com.stock.xxx.vo;

import java.util.List;

/**
 * Created by JiYanLong on 2017/3/9.
 */
public class StockDataVo {

    private Integer showapi_res_code;
    private String showapi_res_error;
    private Showapi_res_body showapi_res_body;

    public Showapi_res_body getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(Showapi_res_body showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public Integer getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(Integer showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public class Showapi_res_body {
        private Integer ret_code;
        private List<StockHistoryVo> list;

        public Integer getRet_code() {
            return ret_code;
        }

        public void setRet_code(Integer ret_code) {
            this.ret_code = ret_code;
        }

        public List<StockHistoryVo> getList() {
            return list;
        }

        public void setList(List<StockHistoryVo> list) {
            this.list = list;
        }

        public class StockHistoryVo {
            private String stockName;
            private String trade_money;
            private String open_price;
            private String code;
            private String date;
            private String market;
            private String min_price;
            private String trade_num;
            private String turnover;
            private String close_price;
            private String max_price;
            private String swing;
            private String diff_rate;
            private String diff_money;


            public String getDiff_money() {
                return diff_money;
            }

            public void setDiff_money(String diff_money) {
                this.diff_money = diff_money;
            }

            public String getStockName() {
                return stockName;
            }

            public void setStockName(String stockName) {
                this.stockName = stockName;
            }

            public String getTrade_money() {
                return trade_money;
            }

            public void setTrade_money(String trade_money) {
                this.trade_money = trade_money;
            }

            public String getOpen_price() {
                return open_price;
            }

            public void setOpen_price(String open_price) {
                this.open_price = open_price;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getMarket() {
                return market;
            }

            public void setMarket(String market) {
                this.market = market;
            }

            public String getMin_price() {
                return min_price;
            }

            public void setMin_price(String min_price) {
                this.min_price = min_price;
            }

            public String getTrade_num() {
                return trade_num;
            }

            public void setTrade_num(String trade_num) {
                this.trade_num = trade_num;
            }

            public String getTurnover() {
                return turnover;
            }

            public void setTurnover(String turnover) {
                this.turnover = turnover;
            }

            public String getClose_price() {
                return close_price;
            }

            public void setClose_price(String close_price) {
                this.close_price = close_price;
            }

            public String getMax_price() {
                return max_price;
            }

            public void setMax_price(String max_price) {
                this.max_price = max_price;
            }

            public String getSwing() {
                return swing;
            }

            public void setSwing(String swing) {
                this.swing = swing;
            }

            public String getDiff_rate() {
                return diff_rate;
            }

            public void setDiff_rate(String diff_rate) {
                this.diff_rate = diff_rate;
            }


        }
    }
}
