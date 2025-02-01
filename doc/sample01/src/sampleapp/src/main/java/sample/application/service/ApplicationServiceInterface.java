package sample.application.service;

public interface ApplicationServiceInterface {
    // アプリケーションのエラーを復帰値ではなく例外に統一するならここで throw するのもあり
    public ApplicationResult calculation(int input);
}
