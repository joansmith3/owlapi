/**
 * 
 */
package org.semanticweb.owlapi.formats;


import org.kohsuke.MetaInfServices;

/**
 * @author Peter Ansell p_ansell@yahoo.com
 * 
 */
@MetaInfServices(OWLOntologyFormatFactory.class)
public class N3OntologyFormatFactory extends AbstractRioRDFOntologyFormatFactory implements RioRDFOntologyFormatFactory
{
    public N3OntologyFormatFactory()
    {
        super();
    }
    
    @Override
    public RioRDFOntologyFormat getNewFormat()
    {
        return new N3OntologyFormat();
    }
    
}
