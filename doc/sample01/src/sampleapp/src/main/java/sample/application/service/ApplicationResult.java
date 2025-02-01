package sample.application.service;

import java.util.Objects;

public class ApplicationResult {
    private double result;
    private double rate;
    private int errcode;
    private String errmsg;

    // 正常時
    public ApplicationResult(double result, double rate) {
        this.result = result;
        this.rate = rate;
        this.errcode = 0;
        this.errmsg = "";
    }

    // 異常時
    public ApplicationResult(int errcode, String errmsg) {
        this.result = 0;
        this.rate = 0;
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    // 値の参照
    public double getResult() {
        return result;
    }

    public double getRate() {
        return rate;
    }

    public int getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    // 各フィールドが一致したら同一扱い
    @Override
    public boolean equals(Object obj) {
        // 同一インスタンスなら当然同一
        if (this == obj) return true;
        // 比較対象が null や別クラスなら比較できない
        if (obj == null || getClass() != obj.getClass()) return false;
        // 各フィールドの比較
        ApplicationResult target = (ApplicationResult) obj;
        return result == target.getResult()
            && rate == target.getRate()
            && errcode == target.getErrcode()
            && Objects.equals(errmsg, target.getErrmsg());
    }
    // equals をオーバーライドする場合は hashCode もオーバーライドする必要がある
    @Override
    public int hashCode() {
        return Objects.hash(result, rate, errcode, errmsg);
    }
    // テスト時に中身を確認したい場合など用の文字列表現
    @Override
    public String toString() {
	    return getClass().getName() + "[ "
          + "result=" + result
          + ", rate=" + rate
          + ", errcode=" + errcode
          + ", errmsg=" + errmsg
          + " ]";
    }

}
