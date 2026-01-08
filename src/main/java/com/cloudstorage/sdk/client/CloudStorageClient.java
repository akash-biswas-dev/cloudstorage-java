package com.cloudstorage.sdk.client;

import com.cloudstorage.sdk.CloudStorageObject;
import com.cloudstorage.sdk.FileObject;

public interface CloudStorageClient {

    FileObject uploadFile(CloudStorageObject storageObject) throws Exception;
}
