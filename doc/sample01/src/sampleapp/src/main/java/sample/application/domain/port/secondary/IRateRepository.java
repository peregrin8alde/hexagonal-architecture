package sample.application.domain;

public interface IRateRepository {
    public int create(double rate);
    public RateEntity read(int id);
}
