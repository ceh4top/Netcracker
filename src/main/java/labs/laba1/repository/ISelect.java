package labs.laba1.repository;

import labs.laba1.entity.IModel;

public interface ISelect<T extends IModel> {
    <L> L getResult(T value);
}