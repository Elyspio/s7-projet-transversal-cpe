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
/**
 *
 * @export
 * @interface Throwable
 */
export interface Throwable {
    /**
     *
     * @type {Throwable}
     * @memberof Throwable
     */
    cause?: any;
    /**
     *
     * @type {Array&lt;StackTraceElement&gt;}
     * @memberof Throwable
     */
    stackTrace?: any;
    /**
     *
     * @type {string}
     * @memberof Throwable
     */
    message?: any;
    /**
     *
     * @type {Array&lt;Throwable&gt;}
     * @memberof Throwable
     */
    suppressed?: any;
    /**
     *
     * @type {string}
     * @memberof Throwable
     */
    localizedMessage?: any;
}
