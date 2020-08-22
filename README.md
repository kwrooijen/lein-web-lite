# Web lite Leiningen template

A simple, bare bones lein template for generating a webapp. Using
[Ring](https://github.com/ring-clojure/ring),
[Aleph](https://github.com/aleph-io/aleph) and
[Reitit](https://github.com/metosin/reitit). This template is meant for
demonstration purposes.

## Setup

```sh
lein new web-lite hello-world
cd hello-world
lein run
```

## Creating a release

```sh
lein uberjar
java -jar target/hello-world.jar
```

## Author / License

Released under the [MIT License] by [Kevin William van Rooijen].

[Kevin William van Rooijen]: https://twitter.com/kwrooijen

[MIT License]: https://github.com/kwrooijen/gungnir/blob/master/LICENSE
