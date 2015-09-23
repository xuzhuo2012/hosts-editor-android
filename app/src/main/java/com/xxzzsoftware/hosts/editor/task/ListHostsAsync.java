package com.xxzzsoftware.hosts.editor.task;

import android.os.AsyncTask;

import com.squareup.otto.Bus;
import com.xxzzsoftware.hosts.editor.R;
import com.xxzzsoftware.hosts.editor.core.Host;
import com.xxzzsoftware.hosts.editor.core.HostsManager;
import com.xxzzsoftware.hosts.editor.event.LoadingEvent;
import com.xxzzsoftware.hosts.editor.event.RefreshHostsEvent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * AsyncTask that gets all valid hosts and triggers a {@code RefreshHostEvent} event.
 */
public class ListHostsAsync extends AsyncTask<Boolean, Void, List<Host>> {

    @Inject
    Bus mBus;
    @Inject
    HostsManager mHostsManager;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mBus.post(new LoadingEvent(true, R.string.loading_hosts));
    }

    @Override
    protected List<Host> doInBackground(Boolean... params) {
        Boolean forceRefresh = params[0];
        if (forceRefresh == null) {
            forceRefresh = false;
        }

        List<Host> allHosts = mHostsManager.getHosts(forceRefresh);

        // Filter to get only valid hosts
        List<Host> validHosts = new ArrayList<Host>();
        for (Host host : allHosts) {
            if (host.isValid()) {
                validHosts.add(host);
            }
        }
        return validHosts;
    }

    @Override
    protected void onPostExecute(List<Host> result) {
        super.onPostExecute(result);
        mBus.post(new RefreshHostsEvent(result));
    }
}
