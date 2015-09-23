package com.xxzzsoftware.hosts.editor.event;

import com.xxzzsoftware.hosts.editor.core.Host;

public class StartAddEditActivityEvent {

    /**
     * The Host entry to modify (edit mode), or {@code null} (add mode).
     */
    public final Host host;

    public StartAddEditActivityEvent(Host addEditHost) {
        host = addEditHost;
    }
}
