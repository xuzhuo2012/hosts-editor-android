package com.xxzzsoftware.hosts.editor.event;

import com.xxzzsoftware.hosts.editor.core.Host;

import java.util.List;

/**
 * Sent to the bus when hosts need to be refreshed.
 */
public class RefreshHostsEvent {

    public final List<Host> hosts;

    public RefreshHostsEvent(List<Host> refreshedHosts) {
        hosts = refreshedHosts;
    }
}
