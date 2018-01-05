package org.uberfire.ext.editor.commons.client.history;

import javax.enterprise.event.Event;

import org.jboss.errai.common.client.api.Caller;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.uberfire.backend.vfs.ObservablePath;
import org.uberfire.client.workbench.type.ClientResourceType;
import org.uberfire.ext.editor.commons.client.BaseEditor;
import org.uberfire.ext.editor.commons.client.file.RestoreUtil;
import org.uberfire.ext.editor.commons.client.file.popups.RestorePopUpPresenter;
import org.uberfire.ext.editor.commons.client.history.event.VersionSelectedEvent;
import org.uberfire.ext.editor.commons.client.menu.MenuItems;
import org.uberfire.ext.editor.commons.version.VersionService;
import org.uberfire.mvp.PlaceRequest;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class VersionRecordsAfterRenameAndSaveTest {

    private static VersionRecordManager versionRecordManager;
    private static BaseEditor baseEditor;

    @Mock
    private static VersionMenuDropDownButton versionMenuDropDownButton;
    @Mock
    private static SaveButton saveButton;
    @Mock
    private static RestorePopUpPresenter restorePopUpPresenter;
    @Mock
    private static RestoreUtil restoreUtil;
    @Mock
    private static Event<VersionSelectedEvent> versionSelectedEvent;
    @Mock
    private static Caller<VersionService> versionServiceCaller;

    @Mock
    private ObservablePath observablePath;
    @Mock
    private PlaceRequest placeRequest;
    @Mock
    private ClientResourceType clientResourceType;

    @Before
    public void setup() {
        versionRecordManager = new VersionRecordManager(
                versionMenuDropDownButton,
                saveButton,
                restorePopUpPresenter,
                restoreUtil,
                versionSelectedEvent,
                versionServiceCaller
        );

        baseEditor = new BaseEditor(versionRecordManager) {
            @Override
            protected void loadContent() {
            }
        };
    }

    @Test
    public void testReproduceAF497() {
        baseEditor.init(observablePath,
                        placeRequest,
                        clientResourceType,
                        true,
                        true,
                        MenuItems.SAVE,
                        MenuItems.DELETE,
                        MenuItems.RENAME,
                        MenuItems.COPY,
                        MenuItems.HISTORY);
        baseEditor.onRename();
        baseEditor.onSave();
        //after rename, the versionRecordManager is not refreshed, so on save the the version history gets out of the index
        assertThat("-1").isNotEqualTo(versionRecordManager.getVersion());
    }
}
