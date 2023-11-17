package com.example.apimanager

interface HttpClientInterface {
     fun<S> create(serviceClass: Class<S>) : S
}