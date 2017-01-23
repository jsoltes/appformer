package org.juraj.mypackage;

import org.juraj.mypackage.myFormName;
import org.juraj.mypackage.myFormNameFormModel;
import org.juraj.mypackage.myFormNameRestService;
import org.livespark.flow.api.Unit;
import java.util.Optional;
import org.livespark.formmodeler.rendering.client.flow.FlowProducer;
import org.jboss.errai.ioc.client.api.EntryPoint;
import java.lang.Override;
import javax.inject.Singleton;
import javax.enterprise.inject.Produces;
import org.livespark.flow.api.AppFlow;
import org.livespark.formmodeler.rendering.client.flow.ForEntity;
import javax.inject.Named;

@EntryPoint
public class myFormNameFlowProducer extends FlowProducer<myFormName, myFormNameFormModel, myFormNameFormView, myFormNameListView, myFormNameRestService>
{

   @Override
   public myFormNameFormModel modelToFormModel(myFormName model)
   {
      return new myFormNameFormModel(model);
   }

   @Override
   public myFormName formModelToModel(myFormNameFormModel formModel)
   {
      return formModel.getmyFormName();
   }

   @Override
   public myFormName newModel()
   {
      return new myFormName();
   }

   @Override
   public Class<myFormName> getModelType()
   {
      return myFormName.class;
   }

   @Override
   public Class<myFormNameFormModel> getFormModelType()
   {
      return myFormNameFormModel.class;
   }

   @Singleton
   @Produces
   public Class<myFormName> entityType()
   {
      return myFormName.class;
   }

   @Override
   @Produces
   @Singleton
   @ForEntity("org.juraj.mypackage.myFormName")
   @Named("create")
   public AppFlow<Unit, Optional<myFormNameFormModel>> create()
   {
      return super.create();
   }

   @Override
   @Produces
   @Singleton
   @ForEntity("org.juraj.mypackage.myFormName")
   @Named("crud")
   public AppFlow<Unit, Unit> crud()
   {
      return super.crud();
   }

   @Override
   @Produces
   @Singleton
   @ForEntity("org.juraj.mypackage.myFormName")
   @Named("createAndReview")
   public AppFlow<Unit, Unit> createAndReview()
   {
      return super.createAndReview();
   }

   @Override
   @Produces
   @Singleton
   @ForEntity("org.juraj.mypackage.myFormName")
   @Named("view")
   public AppFlow<Unit, Unit> view()
   {
      return super.view();
   }
}