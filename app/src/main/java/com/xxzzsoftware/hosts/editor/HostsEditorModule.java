package com.xxzzsoftware.hosts.editor;

import com.squareup.otto.Bus;
import com.xxzzsoftware.hosts.editor.task.AddEditHostAsync;
import com.xxzzsoftware.hosts.editor.task.ListHostsAsync;
import com.xxzzsoftware.hosts.editor.task.RemoveHostsAsync;
import com.xxzzsoftware.hosts.editor.task.ToggleHostsAsync;
import com.xxzzsoftware.hosts.editor.ui.addedit.AddEditHostActivity;
import com.xxzzsoftware.hosts.editor.ui.addedit.AddEditHostFragment;
import com.xxzzsoftware.hosts.editor.ui.list.ListHostsActivity;
import com.xxzzsoftware.hosts.editor.ui.list.ListHostsFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                AddEditHostActivity.class,
                AddEditHostAsync.class,
                AddEditHostFragment.class,
                ListHostsActivity.class,
                ListHostsAsync.class,
                ListHostsFragment.class,
                RemoveHostsAsync.class,
                ToggleHostsAsync.class
        }
)
/**
 * Define this kind of module
 * Dagger module
 */
public class HostsEditorModule {

    @Provides
    @Singleton
    Bus provideBus() {
        return new Bus();
    }
}
