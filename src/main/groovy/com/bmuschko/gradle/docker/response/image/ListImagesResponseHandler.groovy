package com.bmuschko.gradle.docker.response.image

import com.bmuschko.gradle.docker.response.ResponseHandler
import org.gradle.api.logging.Logger
import org.gradle.api.logging.Logging

class ListImagesResponseHandler implements ResponseHandler<Void, List> {
    Logger logger = Logging.getLogger(ListImagesResponseHandler)

    @Override
    Void handle(List images) {
        for(image in images) {
            logger.quiet "Repository Tags : ${image.repoTags?.join(', ')}"
            logger.quiet "Image ID        : $image.id"
            logger.quiet "Created         : ${new Date(image.created * 1000)}"
            logger.quiet "Virtual Size    : $image.virtualSize"
            logger.quiet "-----------------------------------------------"
        }
    }
}
