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
 * @interface FireTypeEntity
 */
export interface FireTypeEntity {
    /**
     * 
     * @type {number}
     * @memberof FireTypeEntity
     */
    id?: any;
    /**
     * 
     * @type {string}
     * @memberof FireTypeEntity
     */
    label?: any;
    /**
     * 
     * @type {string}
     * @memberof FireTypeEntity
     */
    description?: any;
    /**
     * 
     * @type {Array&lt;TruckTypeEntity&gt;}
     * @memberof FireTypeEntity
     */
    truckTypes?: any;
    /**
     * 
     * @type {Array&lt;FireEntity&gt;}
     * @memberof FireTypeEntity
     */
    fires?: any;
    /**
     * 
     * @type {Array&lt;SensorEntity&gt;}
     * @memberof FireTypeEntity
     */
    sensors?: any;
}