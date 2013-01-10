define([
	"views/ApplicationView",
	"views/VolumeInfoListView",
	"views/VolumeInfoView",
	"controllers/ApplicationController",
	"controllers/VolumeInfoListController",
	"models/Volume",
	"models/VolumeInfo",
	"models/Category",
	"models/ImageLink",
	"models/IndustryIdentifier",
	"app/router",
	"ember_data"
], function(ApplicationView,VolumeInfoListView,VolumeInfoView,ApplicationController,VolumeInfoListController,
		Volume,VolumeInfo,Category,ImageLink,IndustryIdentifier,Router){
	/*Module Pattern*/
	var App = Ember.Mixin.create({
		ApplicationView: ApplicationView,
		VolumeInfoListView: VolumeInfoListView,
		VolumeInfoView: VolumeInfoView,
		ApplicationController: ApplicationController,
		VolumeInfoListController: VolumeInfoListController,
		Router: Router,
		Volume:Volume,
		VolumeInfo:VolumeInfo,
		Category:Category,
		ImageLink:ImageLink,
		IndustryIdentifier:IndustryIdentifier,
		
		store:DS.Store.create({
            revision:4,
            adapter:DS.RESTAdapter.create({
                bulkCommit:false,
//                serializer:DS.Serializer.create({
//                    primaryKey:function (type) {
//                    return type.pk;
//                    }
//                }),
                mappings:{
                	volume:Volume,
                	volume_info:VolumeInfo,
                	category:Category,
                	image_links:ImageLink,
                	industry_identifier:IndustryIdentifier,
                },plurals:{
                	volume:'volumes',
                	category:'categories',
                	industry_identifier:'industryIdentifiers'
                },
                namespace:'rest'    //you should change the first segment according to the  application's  folder path on the server.
            })
        }),
        ready:function () {
        }
	});

	return App;
});
