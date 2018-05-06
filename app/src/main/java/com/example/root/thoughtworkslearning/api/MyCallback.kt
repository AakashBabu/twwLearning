package com.example.root.thoughtworkslearning.api

import com.example.root.thoughtworkslearning.pattern.model.BaseModel

interface MyCallback {
        fun onSuccess(baseModel: BaseModel?)
        fun onError()

}