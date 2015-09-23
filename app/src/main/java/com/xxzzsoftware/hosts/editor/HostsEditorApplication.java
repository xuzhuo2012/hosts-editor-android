package com.xxzzsoftware.hosts.editor;

import android.app.Application;
import android.content.Context;

import dagger.ObjectGraph;
import timber.log.Timber;


/**
 * Creates and provides access to Dagger's {@link ObjectGraph} instance.
 * Dagger
 */
public class HostsEditorApplication extends Application {

    private ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
        buildObjectGraph();
    }

    /**
     * inject
     * @param target
     */
    public void inject(Object target) {
        mObjectGraph.inject(target);
    }

    /**
     * get
     *
     * @param type
     * @param <T>
     * @return
     */
    public <T> T get(Class<T> type) {
        return mObjectGraph.get(type);
    }

    /**
     * get application from context
     * @param context
     * @return
     */
    public static HostsEditorApplication get(Context context) {
        return (HostsEditorApplication) context.getApplicationContext();
    }

    /**
     * Logger
     */
    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    /**
     * build object graph
     */
    private void buildObjectGraph() {
        mObjectGraph = ObjectGraph.create(new HostsEditorModule());
    }
}
