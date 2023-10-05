# Build
custom_build(
    # Name of container image
    ref='order-service',
    # Command to build container image
    command='./gradlew bootBuildImage --imageName $EXPECTED_REF',
    # Files to watch that trigger a new build
    deps=['build.gradle', 'src']
)

# Deploy
k8s_yaml(['k8s/order-service.yml'])

# Manage
k8s_resource('order-service', port_forwards=['9002'])