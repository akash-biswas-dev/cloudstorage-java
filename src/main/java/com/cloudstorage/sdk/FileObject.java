package com.cloudstorage.sdk;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class FileObject {
    private String fileId;
    private Long size;
    private String accessUrl;
    private Visibility visibility;
}
