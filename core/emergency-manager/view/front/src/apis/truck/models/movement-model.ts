/* tslint:disable */
/* eslint-disable */
/**
 * Api documentation
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
/**
 * 
 * @export
 * @interface MovementModel
 */
export interface MovementModel {
    /**
     * 
     * @type {Array&lt;TruckModel&gt;}
     * @memberof MovementModel
     */
    trucks?: any;
    /**
     * 
     * @type {Array&lt;FiremanModel&gt;}
     * @memberof MovementModel
     */
    firemen?: any;
    /**
     * 
     * @type {LocationModel}
     * @memberof MovementModel
     */
    dest?: any;
    /**
     * 
     * @type {number}
     * @memberof MovementModel
     */
    resourceId?: any;
}
