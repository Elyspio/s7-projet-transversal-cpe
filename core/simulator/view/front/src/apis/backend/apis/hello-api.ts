/* tslint:disable */
/* eslint-disable */
/**
 *
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.2
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import globalAxios, {AxiosInstance, AxiosPromise} from 'axios';
import {Configuration} from '../configuration';
// Some imports not used depending on template conditions
// @ts-ignore
import {BASE_PATH, BaseAPI, COLLECTION_FORMATS, RequestArgs, RequiredError} from '../base';

/**
 * HelloApi - axios parameter creator
 * @export
 */
export const HelloApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         *
         * @summary Returns the list of fires
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        fires: async (options: any = {}): Promise<RequestArgs> => {
            const localVarPath = `/resources/fires`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions = {method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            const query = new URLSearchParams(localVarUrlObj.search);
            for (const key in localVarQueryParameter) {
                query.set(key, localVarQueryParameter[key]);
            }
            for (const key in options.query) {
                query.set(key, options.query[key]);
            }
            localVarUrlObj.search = (new URLSearchParams(query)).toString();
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: localVarUrlObj.pathname + localVarUrlObj.search + localVarUrlObj.hash,
                options: localVarRequestOptions,
            };
        },
        /**
         *
         * @summary Returns the list of simulator's
         * @param {number} [sensorId]
         * @param {number} [intensity]
         * @param {number} [fireTypeId]
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        send: async (sensorId?: number, intensity?: number, fireTypeId?: number, options: any = {}): Promise<RequestArgs> => {
            const localVarPath = `/resources/send`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions = {method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;
            const localVarFormParams = new FormData();


            if (sensorId !== undefined) {
                localVarFormParams.append('sensorId', sensorId as any);
            }

            if (intensity !== undefined) {
                localVarFormParams.append('intensity', intensity as any);
            }

            if (fireTypeId !== undefined) {
                localVarFormParams.append('fireTypeId', fireTypeId as any);
            }

            localVarHeaderParameter['Content-Type'] = 'multipart/form-data';
            const query = new URLSearchParams(localVarUrlObj.search);
            for (const key in localVarQueryParameter) {
                query.set(key, localVarQueryParameter[key]);
            }
            for (const key in options.query) {
                query.set(key, options.query[key]);
            }
            localVarUrlObj.search = (new URLSearchParams(query)).toString();
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = localVarFormParams;

            return {
                url: localVarUrlObj.pathname + localVarUrlObj.search + localVarUrlObj.hash,
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * HelloApi - functional programming interface
 * @export
 */
export const HelloApiFp = function (configuration?: Configuration) {
    return {
        /**
         *
         * @summary Returns the list of fires
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async fires(options?: any): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await HelloApiAxiosParamCreator(configuration).fires(options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs = {...localVarAxiosArgs.options, url: basePath + localVarAxiosArgs.url};
                return axios.request(axiosRequestArgs);
            };
        },
        /**
         *
         * @summary Returns the list of simulator's
         * @param {number} [sensorId]
         * @param {number} [intensity]
         * @param {number} [fireTypeId]
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async send(sensorId?: number, intensity?: number, fireTypeId?: number, options?: any): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await HelloApiAxiosParamCreator(configuration).send(sensorId, intensity, fireTypeId, options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs = {...localVarAxiosArgs.options, url: basePath + localVarAxiosArgs.url};
                return axios.request(axiosRequestArgs);
            };
        },
    }
};

/**
 * HelloApi - factory interface
 * @export
 */
export const HelloApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    return {
        /**
         *
         * @summary Returns the list of fires
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        fires(options?: any): AxiosPromise<void> {
            return HelloApiFp(configuration).fires(options).then((request) => request(axios, basePath));
        },
        /**
         *
         * @summary Returns the list of simulator's
         * @param {number} [sensorId]
         * @param {number} [intensity]
         * @param {number} [fireTypeId]
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        send(sensorId?: number, intensity?: number, fireTypeId?: number, options?: any): AxiosPromise<void> {
            return HelloApiFp(configuration).send(sensorId, intensity, fireTypeId, options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * HelloApi - object-oriented interface
 * @export
 * @class HelloApi
 * @extends {BaseAPI}
 */
export class HelloApi extends BaseAPI {
    /**
     *
     * @summary Returns the list of fires
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof HelloApi
     */
    public fires(options?: any) {
        return HelloApiFp(this.configuration).fires(options).then((request) => request(this.axios, this.basePath));
    }

    /**
     *
     * @summary Returns the list of simulator's
     * @param {number} [sensorId]
     * @param {number} [intensity]
     * @param {number} [fireTypeId]
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof HelloApi
     */
    public send(sensorId?: number, intensity?: number, fireTypeId?: number, options?: any) {
        return HelloApiFp(this.configuration).send(sensorId, intensity, fireTypeId, options).then((request) => request(this.axios, this.basePath));
    }
}