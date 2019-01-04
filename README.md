# deployonfriday-observability
Observability and monitoring for the Deploy On Friday series

# Prerequisites
1. A JDK installed locally
2. An account on Pivotal Web Services (PWS): https://run.pivotal.io
3. The CF CLI installed (https://github.com/cloudfoundry/cli)

# How to use
1. Check out the project and build it locally using 'mvnw package' (Windows) or './mvnw package' (Linux/OSX)
2. Login to PWS and you org/space using the CF CLI
3. 'cf create service metrics-forwarder unlimited my-metrics-forwarder'
4. 'cf push'
