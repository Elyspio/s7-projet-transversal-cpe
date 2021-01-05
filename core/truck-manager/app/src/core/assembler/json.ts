export abstract class BaseAssembler<Model, Entity> {

    public abstract toEntity(obj: Model): Entity;

    public abstract toModel(json: Entity): Model;

    public collectionToModel(entities: Entity[]): Model[] {
        return entities.map(e => this.toModel(e))

    }

    public collectionToEntity(models: Model[]): Entity[] {
        return models.map(m => this.toEntity(m))
    }


}
