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
 * @interface FireTruckEntity
 */
export interface FireTruckEntity {
    /**
     * 
     * @type {number}
     * @memberof FireTruckEntity
     */
    id?: any;
    /**
     * 
     * @type {BarrackEntity}
     * @memberof FireTruckEntity
     */
    barrack?: any;
    /**
     * 
     * @type {TruckTypeEntity}
     * @memberof FireTruckEntity
     */
    type?: any;
    /**
     * 
     * @type {Array&lt;ResourceEntity&gt;}
     * @memberof FireTruckEntity
     */
    resources?: any;
}
