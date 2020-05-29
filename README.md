
# Manorrock Munchkin

## Deploy the server using Docker

```
  docker run --rm -d -p 8080:8080 manorrock/munchkin:VERSION
```

And replace VERSION with the version you want to use.

## Testing SNAPSHOT versions

Every night we push a SNAPSHOT version to Docker Hub. If you want to give the
version under development a test drive use `snapshot` as the version for the
instructions above.

## Important notice

Note if you file issues or answer questions on the issue tracker and/or issue 
pull requests you agree that those contributions will be owned by Manorrock.com
and that Manorrock.com can use those contributions in any manner Manorrock.com
so desires.
