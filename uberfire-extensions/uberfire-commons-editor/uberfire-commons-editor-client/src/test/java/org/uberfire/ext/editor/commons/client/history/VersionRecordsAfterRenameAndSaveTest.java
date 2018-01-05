package org.uberfire.ext.editor.commons.client.history;

import javax.enterprise.event.Event;

import org.jboss.errai.common.client.api.Caller;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.uberfire.ext.editor.commons.client.file.RestoreUtil;
import org.uberfire.ext.editor.commons.client.file.popups.RestorePopUpPresenter;
import org.uberfire.ext.editor.commons.client.history.event.VersionSelectedEvent;
import org.uberfire.ext.editor.commons.version.VersionService;

public class VersionRecordsAfterRenameAndSaveTest {

    private static VersionRecordManager versionRecordManager;

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
    }

    @Test
    public void testGetCurrentVersionIndex() {
        //call baseEditor.init(); then call baseEditor.onRename()
        //assert that the versionHistory has changed to contain the new commit
    }
}
