package google.architecture.coremodel.datamodel.http.repository;

import google.architecture.coremodel.datamodel.http.ApiClient;
import google.architecture.coremodel.datamodel.http.entities.AndroidData;
import google.architecture.coremodel.datamodel.http.entities.FuliData;
import io.reactivex.Observable;

/**
 * Created by dxx on 2017/11/8.
 */

public class GankDataRepository {

    public static Observable<FuliData>  getFuliDataRepository(String size, String index){

        Observable<FuliData> observableForGetFuliDataFromNetWork = ApiClient.getGankDataService().getFuliData(size,index);

        //可以操作Observable来筛选网络或者是本地数据

        return observableForGetFuliDataFromNetWork;
    }

    public static Observable<AndroidData> getAndroidDataRepository(String size, String index){

        Observable<AndroidData> observableForGetAndroidDataFromNetWork = ApiClient.getGankDataService().getAndroidData(size,index);

        //可以操作Observable来筛选网络或者是本地数据

        return observableForGetAndroidDataFromNetWork;
    }

}
