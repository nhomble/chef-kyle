# chef kyle

If I work much harder, I should work at elastic.

## Demo

![](./docs/demo.gif)

## Usage

Simplest thing is to run the mvn plugin:

```shell
mvn spring-boot:run
```

### Adding more recipes

You can add `.yml` files into the directory of your choice and then you just load the directory in the shell.

```yaml
recipeName: the id
ingredients:
  name of it: quantity of it (it's going to be a number)
  eggs: 1
```

You can see my [dumb examples here](./recipes)