package com.medhdj.domain.usecase;

import org.apache.commons.lang3.Validate;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;


/**
 * Created by medhdj on 22/01/2018.
 */

public abstract class UseCase<T, Params> {
    private final CompositeDisposable disposables;

    public UseCase() {
        disposables = new CompositeDisposable();
    }

    abstract Observable<T> buildUseCaseObservable(Params params);

    public void execute(DisposableObserver<T> observer, Params params) {
        Validate.notNull(observer);
        final Observable<T> observable = this.buildUseCaseObservable(params);
        addDisposable(observable.subscribeWith(observer));

    }

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    private void addDisposable(Disposable disposable) {
        Validate.notNull(disposable);
        Validate.notNull(disposables);
        disposables.add(disposable);
    }
}
