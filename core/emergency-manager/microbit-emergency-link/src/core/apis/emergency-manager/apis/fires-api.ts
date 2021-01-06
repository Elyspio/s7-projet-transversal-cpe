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
import { FireResourceNewFire } from '../models';
/**
 * FiresApi - axios parameter creator
 * @export
 */
export const FiresApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * 
         * @summary add or update a fire
         * @param {FireResourceNewFire} [body] 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        newFire: async (body?: FireResourceNewFire, options: any = {}): Promise<RequestArgs> => {
            const localVarPath = `/fires`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, 'https://example.com');
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            localVarHeaderParameter['Content-Type'] = 'application/json';

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
            const needsSerialization = (typeof body !== "string") || localVarRequestOptions.headers['Content-Type'] === 'application/json';
            localVarRequestOptions.data =  needsSerialization ? JSON.stringify(body !== undefined ? body : {}) : (body || "");

            return {
                url: localVarUrlObj.pathname + localVarUrlObj.search + localVarUrlObj.hash,
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * FiresApi - functional programming interface
 * @export
 */
export const FiresApiFp = function(configuration?: Configuration) {
    return {
        /**
         * 
         * @summary add or update a fire
         * @param {FireResourceNewFire} [body] 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async newFire(body?: FireResourceNewFire, options?: any): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await FiresApiAxiosParamCreator(configuration).newFire(body, options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs = {...localVarAxiosArgs.options, url: basePath + localVarAxiosArgs.url};
                return axios.request(axiosRequestArgs);
            };
        },
    }
};

/**
 * FiresApi - factory interface
 * @export
 */
export const FiresApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    return {
        /**
         * 
         * @summary add or update a fire
         * @param {FireResourceNewFire} [body] 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        newFire(body?: FireResourceNewFire, options?: any): AxiosPromise<void> {
            return FiresApiFp(configuration).newFire(body, options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * FiresApi - object-oriented interface
 * @export
 * @class FiresApi
 * @extends {BaseAPI}
 */
export class FiresApi extends BaseAPI {
    /**
     * 
     * @summary add or update a fire
     * @param {FireResourceNewFire} [body] 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof FiresApi
     */
    public newFire(body?: FireResourceNewFire, options?: any) {
        return FiresApiFp(this.configuration).newFire(body, options).then((request) => request(this.axios, this.basePath));
    }
}
