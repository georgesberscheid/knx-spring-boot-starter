package lu.berscheid.knx.commandline;

import org.springframework.stereotype.Component;

import com.github.rvesse.airline.annotations.Cli;
import com.github.rvesse.airline.help.Help;

@Component
@Cli(name = "knx-devicename",
		description = "KNX Device command line",
		defaultCommand = Help.class,
		commands = { StartCommand.class, CreateKnxProdCommand.class, Help.class })
public class KnxCommandlineParser {
}
