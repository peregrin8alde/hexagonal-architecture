package sample.adapter.test;

import sample.application.domain.*;
import sample.application.*;

import java.util.Objects;

public class TestResult {

    private int status;
    private ResultValue resultValue;
    private String msg;

    public TestResult(int status, ResultValue resultValue, String msg) {
        this.status = status;
        this.resultValue = resultValue;
        this.msg = msg;
    }

    // getter
    public int getStatus() {
        return status;
    }

    public ResultValue getResultValue() {
        return resultValue;
    }

    public String getMsg() {
        return msg;
    }

    // 正しい結果と比較する必要がある
    // 同一インスタンスかどうかではなく、各フィールドの内容が同じかどうかで判定したいため equals をオーバーライド
    @Override
    public boolean equals(Object obj) {
        // 同一インスタンスなら当然同一
        if (this == obj) return true;
        // 比較対象が null や別クラスなら比較できない
        if (obj == null || getClass() != obj.getClass()) return false;
        // 各フィールドの比較
        TestResult testResult = (TestResult) obj;
        return status == testResult.getStatus()
            && resultValue.getData() == testResult.getResultValue().getData()
            && resultValue.getRate() == testResult.getResultValue().getRate()
            && Objects.equals(msg, testResult.getMsg());
    }
    // equals をオーバーライドする場合は hashCode もオーバーライドする必要がある
    @Override
    public int hashCode() {
        return Objects.hash(status, resultValue, msg);
    }
    // 結果が異なる場合の出力
    @Override
    public String toString() {
	    return getClass().getName() + "[ "
          + "status=" + status
          + ", resultValue.data=" + resultValue.getData()
          + ", resultValue.rate=" + resultValue.getRate()
          + ", msg=" + msg
          + " ]";
    }

}
