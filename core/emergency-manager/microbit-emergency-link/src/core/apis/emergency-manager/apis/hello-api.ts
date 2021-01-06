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
import globalAxios, { AxiosPromise, AxiosInstance } from 'axios';
import { Configuration } from '../configuration';
// Some imports not used depending on template conditions
// @ts-ignore
import { BASE_PATH, COLLECTION_FORMATS, RequestArgs, BaseAPI, RequiredError } from '../base';
/**
 * HelloApi - axios parameter creator
 * @export
 */
export const HelloApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * 
         * @summary test the world
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        hello: async (options: any = {}): Promise<RequestArgs> => {
            const localVarPath = `/hello-world`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
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
         * @summary test the microbit (simulator) link
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        testLink: async (options: any = {}): Promise<RequestArgs> => {
            const localVarPath = `/hello-world/link`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
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
    }
};

/**
 * HelloApi - functional programming interface
 * @export
 */
export const HelloApiFp = function(configuration?: Configuration) {
    return {
        /**
         * 
         * @summary test the world
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async hello(options?: any): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await HelloApiAxiosParamCreator(configuration).hello(options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs = {...localVarAxiosArgs.options, url: basePath + localVarAxiosArgs.url};
                return axios.request(axiosRequestArgs);
            };
        },
        /**
         * 
         * @summary test the microbit (simulator) link
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async testLink(options?: any): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await HelloApiAxiosParamCreator(configuration).testLink(options);
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
         * @summary test the world
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        hello(options?: any): AxiosPromise<void> {
            return HelloApiFp(configuration).hello(options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary test the microbit (simulator) link
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        testLink(options?: any): AxiosPromise<void> {
            return HelloApiFp(configuration).testLink(options).then((request) => request(axios, basePath));
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
     * @summary test the world
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof HelloApi
     */
    public hello(options?: any) {
        return HelloApiFp(this.configuration).hello(options).then((request) => request(this.axios, this.basePath));
    }
    /**
     * 
     * @summary test the microbit (simulator) link
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof HelloApi
     */
    public testLink(options?: any) {
        return HelloApiFp(this.configuration).testLink(options).then((request) => request(this.axios, this.basePath));
    }
}