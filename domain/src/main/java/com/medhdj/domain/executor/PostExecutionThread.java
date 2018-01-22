package com.medhdj.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by medhdj on 22/01/2018.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
