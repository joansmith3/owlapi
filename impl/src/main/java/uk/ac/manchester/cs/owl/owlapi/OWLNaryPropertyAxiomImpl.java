/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, The University of Manchester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, University of Manchester
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.manchester.cs.owl.owlapi;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLNaryPropertyAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.util.CollectionFactory;

/** @author Matthew Horridge, The University Of Manchester, Bio-Health Informatics
 *         Group, Date: 26-Oct-2006
 * @param <P>
 *            the property expression */
public abstract class OWLNaryPropertyAxiomImpl<P extends OWLPropertyExpression<?, ?>>
        extends OWLPropertyAxiomImpl implements OWLNaryPropertyAxiom<P> {
    private static final long serialVersionUID = 30406L;
    private final Set<P> properties;

    /** @param properties
     *            properties
     * @param annotations
     *            annotations */
    public OWLNaryPropertyAxiomImpl(Set<? extends P> properties,
            Collection<? extends OWLAnnotation> annotations) {
        super(annotations);
        this.properties = new TreeSet<P>(properties);
    }

    @Override
    public Set<P> getProperties() {
        return CollectionFactory.getCopyOnRequestSetFromImmutableCollection(properties);
    }

    @Override
    public Set<P> getPropertiesMinus(P property) {
        Set<P> props = new TreeSet<P>(properties);
        props.remove(property);
        return props;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            if (!(obj instanceof OWLNaryPropertyAxiom)) {
                return false;
            }
            return ((OWLNaryPropertyAxiom<?>) obj).getProperties().equals(properties);
        }
        return false;
    }

    @Override
    protected int compareObjectOfSameType(OWLObject object) {
        return compareSets(properties, ((OWLNaryPropertyAxiom<?>) object).getProperties());
    }
}
