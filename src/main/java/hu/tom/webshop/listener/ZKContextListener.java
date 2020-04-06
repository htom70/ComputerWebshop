package hu.tom.webshop.listener;


import hu.tom.webshop.dao.HibernateUtil;
import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.WebAppCleanup;
import org.zkoss.zk.ui.util.WebAppInit;

public class ZKContextListener implements WebAppInit, WebAppCleanup {


    @Override
    public void init(WebApp webApp) throws Exception {
        HibernateUtil.init();

    }

    @Override
    public void cleanup(WebApp webApp) throws Exception {
        HibernateUtil.destroy();
    }
}

