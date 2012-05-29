/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.guvnor.client.editor;

import javax.enterprise.context.Dependent;

import org.drools.guvnor.client.mvp.IPlaceRequest;
import org.drools.guvnor.client.mvp.PlaceRequest;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

@Dependent
public class MyAdminAreaPlace extends PlaceRequest implements IPlaceRequest {

    private String MY_ADMIN_AREA = "MyAdminArea";
    
    public MyAdminAreaPlace() {
        super("MyAdminArea");
    }
    
    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        MyAdminAreaPlace place = (MyAdminAreaPlace) o;

        if ( MY_ADMIN_AREA != null ? !MY_ADMIN_AREA.equals( place.MY_ADMIN_AREA ) : place.MY_ADMIN_AREA != null ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return MY_ADMIN_AREA != null ? MY_ADMIN_AREA.hashCode() : 0;
    }

    public static class Tokenizer implements PlaceTokenizer<MyAdminAreaPlace> {

        public String getToken(MyAdminAreaPlace place) {
            return "MY_ADMIN_AREA";
        }

        public MyAdminAreaPlace getPlace(String token) {
            return new MyAdminAreaPlace();
        }
    }
}
