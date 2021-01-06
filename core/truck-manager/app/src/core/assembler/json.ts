export abstract class BaseAssembler<Model, Entity> {

    public abstract toEntity(obj: Model, ...args: any[]): Entity;

    public abstract toModel(json: Entity, ...args: any[]): Model;

    public collectionToModel(models: {model:  Entity,  args?:  any[] }[]): Model[] {
        return models.map(({args, model}) => this.toModel(model, args))
    }

    public collectionToEntity(models: {model:  Model,  args?:  any[] }[]): Entity[] {
        return models.map(({args, model}) => this.toEntity(model, args))
    }


}
