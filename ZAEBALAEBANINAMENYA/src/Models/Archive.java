package Models;

import java.util.ArrayList;
import java.util.List;

public class Archive {
    private int archiveId;
    private String archiveName;

    public Archive(int archiveId, String archiveName) {
        this.archiveId = archiveId;
        this.archiveName = archiveName;
    }

    public int getArchiveId() {
        return archiveId;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }
}