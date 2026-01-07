package com.cloudstorage.sdk;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.File;
import java.nio.file.Path;

@Getter
@Builder
@AllArgsConstructor
public class CloudStorageObject {
    private String key;
    private Visibility visibility;
    private Path filePath;
}
