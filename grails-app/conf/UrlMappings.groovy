class UrlMappings {


        static mappings = {
                "/$controller/$action?/$id?"{
                        constraints {
                                // apply constraints here
                        }
                }
				"/"(view:"/index")
                "500"(view:'/error')
        "/user/create"(controller:'user',action:'createUser')
        "/user/save"(controller:'user',action:'saveUser')
        }
}
