package com.bazaarvoice.emodb.web.migrator.migratorstatus;

import com.bazaarvoice.emodb.web.scanner.ScanOptions;
import com.bazaarvoice.emodb.web.scanner.scanstatus.ScanRangeStatus;
import com.bazaarvoice.emodb.web.scanner.scanstatus.ScanStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.List;

public class MigratorStatus extends ScanStatus {

    private int _maxWritesPerSecond;

    public MigratorStatus(ScanStatus scanStatus, int maxWritesPerSecond) {
        this(scanStatus.getScanId(), scanStatus.getOptions(), scanStatus.isCanceled(),
                scanStatus.getStartTime(), scanStatus.getPendingScanRanges(),
                scanStatus.getActiveScanRanges(), scanStatus.getCompleteScanRanges(),
                scanStatus.getCompleteTime(), maxWritesPerSecond);
    }

    @JsonCreator
    public MigratorStatus(@JsonProperty ("scanId") String scanId,
                      @JsonProperty ("options") ScanOptions options,
                      @JsonProperty ("canceled") boolean canceled,
                      @JsonProperty ("startTime") Date startTime,
                      @JsonProperty ("pendingScanRanges") List<ScanRangeStatus> pendingMigrationRanges,
                      @JsonProperty ("activeScanRanges") List<ScanRangeStatus> activeMigrationRanges,
                      @JsonProperty ("completeScanRanges") List<ScanRangeStatus> completeMigrationRanges,
                      @JsonProperty ("completeTime") @Nullable Date completeTime,
                      @JsonProperty ("maxWritesPerSecond") int maxWritesPerSecond) {
        super(scanId, options, false, canceled, startTime, pendingMigrationRanges, activeMigrationRanges, completeMigrationRanges, completeTime);
        _maxWritesPerSecond = maxWritesPerSecond;
    }

    public int getMaxWritesPerSecond() {
        return _maxWritesPerSecond;
    }

    public void setMaxWritesPerSecond(int maxWritesPerSecond) {
        _maxWritesPerSecond = maxWritesPerSecond;
    }
}
