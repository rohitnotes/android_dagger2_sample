package samples.linhtruong.com.dagger2sample.di.component;

import dagger.Component;
import samples.linhtruong.com.dagger2sample.app.App;
import samples.linhtruong.com.dagger2sample.login.SplashActivity;
import samples.linhtruong.com.dagger2sample.di.module.AppModule;
import samples.linhtruong.com.dagger2sample.di.module.NetworkModule;
import samples.linhtruong.com.dagger2sample.network.APIService;
import samples.linhtruong.com.dagger2sample.di.scope.ApplicationScope;
import samples.linhtruong.com.dagger2sample.storage.DbManager;
import samples.linhtruong.com.dagger2sample.storage.LoginSession;
import samples.linhtruong.com.utils.LogUtils;

/**
 * CLASS DESCRIPTION
 *
 * @author linhtruong
 * @date 3/4/17 - 01:36.
 * @organization VED
 */

@ApplicationScope
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    final class Initialiazer {
        public static AppComponent init(App app) {
            return DaggerAppComponent.builder().appModule(new AppModule(app)).build();
        }
    }

    void inject(SplashActivity activity);

    APIService exposeAPIService();
    DbManager exposeDBManager();
    LoginSession exposeLoginSession();
}
